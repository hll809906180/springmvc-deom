package cn.leadeon.comm;

import lombok.Data;

import java.util.List;

/**
 * json 返回体
 */
@Data
public class JsonResult {
    private int tatol;
    private List rows;
    private String resultCode;
    private String resultMsg;
}
