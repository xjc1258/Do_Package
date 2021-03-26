package Gold;

import java.util.HashMap;
import java.util.Map;



/**
 * 
 * @常量，帮手类
 * @HelperUtils
 * @author xjc
 * @2018-9-28
 */
public class HelperUtils
{
    // 报表内容
    // 接收的信息
    public static final String defcode = "1001";                // defcode=1001
    public static final String code = "code";                   // 业务编码 1001
    public static final String billNo = "billNo";               // NC单据号 NC报销单单据号
    public static final String billId = "billId";               // NC单据主键 NC报销单单据主键
    public static final String transiType = "transiType";       // NC单据交易类型NC单据交易类型
    public static final String approveResult = "approveResult"; // 审批结果 0（同意），1（不同意）
    public static final String approveMsg = "approveMsg";       // 审批信息
    public static final String approveUser = "approveUser";     // 审批人
    public static final String date = "date";                   // 审批日期 日期格式字符串,例如:2018-01-01 00:00:00
    public static final String def1 = "def1";                   // 预留字段1
    public static final String def2 = "def2";                   // 预留字段2
    public static final String def3 = "def3";                   // 预留字段3
    public static final String def4 = "def4";                   // 预留字段4
    public static final String def5 = "def5";                   // 预留字段5
    // 反馈信息
    public static final String RESULT_CODE = "resultCode";      // 回代码
    public static final String RESULT_MSG = "resultMsg";        // 结果信息
    // 状态代码
    public static final String RESULTCODE_SCC = "01";           // 成功
    public static final String RESULTCODE_SCC_MSG = "单据操作成功！";// 成功
    public static final String RESULTCODE_FAIL = "02";          // 失败
    public static final String RESULTCODE_FAIL_MSG1 = "未找到审批流信息!";// 失败
    public static final String RESULTCODE_FAIL_MSG2 = "该流程后存在指派操作，请在PC端审批！";
    public static final String RESULTCODE_FAIL_MSG3 = "当前单据不是报销单据，请确认！";
    public static final String RESULTCODE_FAIL_MSG4 = "未找到已审批流程!";// 失败
    public static final String RESULT_SCC = "远程操作成功！";//
    public static final String SIGNAL = "SIGNAL";//
    public static final String APPROVE = "APPROVE";//
    public static final String DEFCODE_FAIT = "默认编码不是[1001]";                // defcode=1001
    public static final String PK_GROUP = "0001A610000000000674";
    // 2018-10-08 15:30:00
    // public static final String time =
    // "/^\\d{4}-(?:0\\d|1[0-2])-(?:[0-2]\\d|3[01]) ((?:[01]\\d|2[0-3])\\:[0-5]\\d\\:[0-5]\\d)?$/";//
    public static final String time =
        "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1][0-9])|([2][0-4]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$";
    public static final String REXP =
        "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
    
    /**
     * 推消息
     * @param msg
     * @return
     */
    public static String pushMsg(String msg)
    {
        
        return "远程操作失敗，错误信息" + msg;
    }
    
    /**
     * 返回消息和状态 Map<String, String>
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static Map<String, String> returnMsg(String resultCode, String resultMsg)
    {
        Map<String, String> msgMap = new HashMap<String, String>();
        msgMap.put(resultCode, resultCode);
        msgMap.put(resultMsg, resultMsg);
        
        return msgMap;
    }
    
    /**
     * 返回消息和状态 json
     * @param resultCode
     * @param resultMsg
     * @return
     */
    public static String returnJsonMsg(String resultCode, String resultMsg)
    {
        StringBuffer msg = new StringBuffer();
        msg.append("{\"").append(RESULT_CODE).append("\":\"").append(resultCode).append("\",\"").append(RESULT_MSG).append("\":\"")
            .append(resultMsg).append("\"}");
        
        return msg.toString();
    }
    
    /**
     * 错误异常消息
     * @param bxVO
     * @param spzt
     * @param isNull
     * @return
     
    public static String exceptionMsg(JKBXHeaderVO bxVO, String spzt, boolean isNull)
    {
        StringBuffer msg = new StringBuffer();
        if (isNull)
        {
            msg.append("\"当前单据[").append(bxVO.getDjbh()).append("，").append(bxVO.getPk_jkbx()).append("]状态标识为<").append(spzt)
                .append(">,不再处理范围之类,请确认！\"");
        }
        msg.append("\"当前单据[").append(bxVO.getDjbh()).append("，").append(bxVO.getPk_jkbx()).append("]状态为<")
            .append((0 == bxVO.getSpzt() ? "审批未通过" : "审批通过")).append(">请确认！\"");
        
        return msg.toString();
    }*/
    
    /**
     * 校验必填项
     * @param jsonMap
     * @return
     */
    public static String isNullMsg(Map<String, Object> jsonMap)
    {
        StringBuffer msg = new StringBuffer();
        msg.append("\"当前单据[").append(jsonMap.get(billNo)).append("，").append(jsonMap.get(billId)).append("] 存在必填项没有填,请确认！\"");
        
        return msg.toString();
    }
    
    /**
     * 校验审批人
     * @param jsonMap
     * @return
     */
    public static String isApproverMsg(Map<String, Object> jsonMap)
    {
        StringBuffer msg = new StringBuffer();
        msg.append("\"当前单据[").append(jsonMap.get(billNo)).append("，").append(jsonMap.get(billId)).append("] 没有对应的审批人,接收到的信息[")
            .append(jsonMap.get(approveUser)).append("],请确认！\"");
        
        return msg.toString();
    }
    
    /**
     * 校验时间格式
     * @param jsonMap
     * @return
     */
    public static String isTimeMsg(Map<String, Object> jsonMap)
    {
        StringBuffer msg = new StringBuffer();
        msg.append("\"当前单据[").append(jsonMap.get(billNo)).append("，").append(jsonMap.get(billId)).append("] 时间格式不正确,接收到的信息[")
            .append(jsonMap.get(date)).append("],请确认！\"");
        
        return msg.toString();
    }
    
    /**
     * 返回結果消息
     * @param jsonMap
     * @param msgMap
     * @param approveResult
     * @return
     */
    public static String returnResMsg(Map<String, Object> jsonMap, Map<String, String> msgMap, boolean isApprover)
    {
        StringBuffer msg = new StringBuffer();
        if (RESULTCODE_FAIL.equals(msgMap.get(RESULT_CODE)))
        {
            msg.append("\"当前单据[").append(jsonMap.get(billNo)).append("，").append(jsonMap.get(billId)).append("] 处理失败，失败原因[")
                .append(msgMap.get(RESULT_MSG)).append("],请确认！\"");
        }
        else
        {
            if (isApprover)
            {
                msg.append("\"").append(jsonMap.get(billNo)).append("\"-审批结果为（同意）,");
                
            }
            else
            {
                msg.append("\"").append(jsonMap.get(billNo)).append("\"-审批结果为（不同意）,");
            }
        }
        
        return msg.toString();
    }
    
    /**
     * Object转String,并去前后空格
     * @param obj
     * @return
     */
    public static String valueOf(Object obj)
    {
        return (obj == null) ? null : obj.toString().trim();
    }
    
    /**
     * 判断int类型
     * @param str
     * @return
     */
    public static boolean isInt(String str)
    {
        return (null == str ? false : str.matches("\\d+"));
    }
    
    /**
     * 判空Object->String
     * @param str
     * @return
     */
    public static boolean isNull(Object str)
    {
        String obj = valueOf(str);
        return (null == obj || obj.length() == 0) ? true : false;
    }
    
}
