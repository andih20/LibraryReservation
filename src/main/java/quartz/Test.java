package quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test{

    public static void main(String[] args) throws BeansException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuartzManager quartzManager = (QuartzManager) ctx.getBean("quartzManager");
        try {
            System.out.println("【系统启动】开始DatabaseScan...");

            // 扫描到了就增加一个job1，七天后移除黑名单的定时
            // System.out.println("【增加job1启动】开始(每10秒输出一次)...");
            // quartzManager.addJob("test", "test", "test", "test", MyJob.class, "0/15 * * * * ?");

            // Thread.sleep(5000);
            // System.out.println("【修改job1时间】开始(每2秒输出一次)...");
            // quartzManager.modifyJobTime("test", "test", "test", "test", "0/2 * * * * ?");

//            Thread.sleep(20000);
//            System.out.println("【移除job1定时】开始...");
            // quartzManager.removeJob("test", "test", "test", "test");

            //关掉任务调度容器
            // quartzManager.shutdownJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}