package com.kyj.cooltiger.common.utils;

import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @author guoxq
 * @version 1.0
 * @date 2020/8/28 9:26
 * 雪花算法生成订单id 分布式自增id
 */
@Data
public class IdWorker {

    private static final Logger logger = LoggerFactory.getLogger(IdWorker.class);


    /** 开始时间截 (201-01-01) */
    private final static long  twepoch=1288834974657L;
     /**机器标识位数*/
    private final static long workerIdBits=5L;
    /** 数据标识id所占的位数 */
    private final static long datacenterIdBits = 5L;

    /** 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数) */
    private final static long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /** 支持的最大数据标识id，结果是31 */
    private final static long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /** 序列在id中占的位数 */
    private final static long sequenceBits = 12L;

    /** 机器ID向左移12位 */
    private final static long workerIdShift = sequenceBits;

    /** 数据标识id向左移17位(12+5) */
    private final static long datacenterIdShift = sequenceBits + workerIdBits;

    /** 时间截向左移22位(5+5+12) */
    private final static long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /** 生成序列的掩码，这里为4095 (0b111111111111=0xfff=4095) */
    private final static long sequenceMask = -1L ^ (-1L << sequenceBits);

    /** 工作机器ID(0~31) */
    private final  long workerId;

    /** 数据中心ID(0~31) */
    private final long datacenterId;

    /** 毫秒内序列(0~4095)   并发控制 */
    private long sequence = 0L;

    /** 上次生成ID的时间截 */
    private static long lastTimestamp = -1L;
    public IdWorker(){
        this.datacenterId=getDataxenterId(maxDatacenterId);
        this.workerId=getMaxWorkerId(datacenterId,maxWorkerId);
    }

    /**
     * 构造函数
     * @param workerId 工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     */
    public IdWorker(long workerId, long datacenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }
    /**
     * 获得下一个ID (该方法是线程安全的)
     * @return SnowflakeId
     */
    public synchronized long nextId() {
        long timestamp = timeGen();
        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }
        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                timestamp = tilNextMillis(lastTimestamp);
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }
        //上次生成ID的时间截
        lastTimestamp = timestamp;
        //移位并通过或运算拼到一起组成64位的ID
        return ((timestamp - twepoch) << timestampLeftShift) //
                | (datacenterId << datacenterIdShift) //
                | (workerId << workerIdShift) //
                | sequence;
    }

    /**
     * 阻塞到下一个毫秒，直到获得新的时间戳
     * @param lastTimestamp 上次生成ID的时间截
     * @return 当前时间戳
     */
    protected long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 返回以毫秒为单位的当前时间
     * @return 当前时间(毫秒)
     */
    protected long timeGen() {
        return System.currentTimeMillis();
    }

    /**
     * 获取 maxworkerid
     * @param datacenterId
     * @param maxWorkerId
     * @return
     */
    protected  static long getMaxWorkerId(long  datacenterId,long maxWorkerId){
        StringBuffer mpid=new StringBuffer();
        mpid.append(datacenterId);
        String name= ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("name*****"+name);
        if(!name.isEmpty()){
            //获取jvm  pid
            mpid.append(name.split("@")[0]);
        }
        return (mpid.toString().hashCode()&0xffff)%(maxWorkerId+1);
    }

    /**
     * 获取标识id部分
     * @param maxDatacenterId
     * @return
     */
    protected  static long getDataxenterId(long maxDatacenterId){
        long id=0L;
        try {
            InetAddress  ip=InetAddress.getLocalHost();
            NetworkInterface networkInterface=NetworkInterface.getByInetAddress(ip);
            if(networkInterface==null){
                id=1L;
            }else {
                byte[] mac=networkInterface.getHardwareAddress();
                id=((0x000000FF & (long) mac[mac.length-1])|(0x0000FF00 &(((long)mac[mac.length-2]) <<8)))>>6;
                id= id % (maxDatacenterId+1);
            }
        }catch (Exception e){
            logger.error("getDataxenterId"+e.getMessage());
            e.printStackTrace();
        }
        return  id ;
    }


    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(0, 0);
        for (int i = 0; i < 10; i++) {
            long id = idWorker.nextId();
            System.out.println(Long.toBinaryString(id));
            System.out.println(id);
        }
        System.out.println("args = [" + getMaxWorkerId(0,maxWorkerId) + "]");

        System.out.println("args = [" + getDataxenterId(maxDatacenterId) + "]");
    }
}
