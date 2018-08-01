package javaImooc.EasySimple;

/**
 * @Author: Donlin
 * @Description: 发通知模板
 * @Date: Created in 16:14 2018/4/12
 * @Version: 1.0
 */
public class notificationRelease {
    private static String PAPER01_NAME = "PrivApprox: Privacy-Preserving Stream Analytics";
    private static String PAPER01_YEAR = "2017";
    private static String PAPER01_PUBLICTION = "USENIX ATC";

    private static String PAPER02_NAME = "Two-Cloud Secure Database for Numeric-Related SQL Range Queries With Privacy Preserving";
    private static String PAPER02_YEAR = "2017";
    private static String PAPER02_PUBLICTION = "TIFS";

    private static String reportPeople = "博士生" + "和" + "研二";

    public static void main(String[] args) {
        StringBuilder model_undergraduate = new StringBuilder();//发到本科生进团队的通知
        model_undergraduate.append("通知：本周六上午9点于B3-408进行论文分享的讨论班，分享的论文分别是");
        model_undergraduate.append(getPaperFormat(PAPER01_NAME, PAPER01_YEAR,PAPER01_PUBLICTION.toUpperCase()));
        model_undergraduate.append("和");
        model_undergraduate.append(getPaperFormat(PAPER02_NAME, PAPER02_YEAR,PAPER02_PUBLICTION.toUpperCase()));
        model_undergraduate.append("，论文已上传钉盘，欢迎本科同学到场学习！");

        System.out.println(model_undergraduate.toString());
        System.out.println("\n");

        StringBuilder model_tanglab = new StringBuilder();//发到实验室的通知
        model_tanglab.append("通知：明天上午9点于B3-408进行实验室的讨论班，分享的论文分别是");
        model_tanglab.append(getPaperFormat(PAPER01_NAME, PAPER01_YEAR,PAPER01_PUBLICTION.toUpperCase()));
        model_tanglab.append("和");
        model_tanglab.append(getPaperFormat(PAPER02_NAME, PAPER02_YEAR,PAPER02_PUBLICTION.toUpperCase()));
        model_tanglab.append("，结束后由" + reportPeople + "同学进行科研工作汇报，请各同学做好准备！");

        System.out.println(model_tanglab.toString());
    }

    public static String getPaperFormat(String name,String time,String publication){
        String result;
        result = time + "年" + publication + "的《" + name + "》";
        return result;
    }
}
