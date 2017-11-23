package com.goule666.himmaForDnf.utils;

/**
 * @author niewenlong
 * @Date 2017/11/23 Time: 13:54
 * @Description 常量
 */
public enum ResponseInfo {
    ////////////// 系统状态码 开始//////////////////
    OK(200,"服务器成功返回用户请求的数据"),
    CREATED(201,"用户新建或修改数据成功"),
    ACCEPTED(202,"表示一个请求已经进入后台排队（异步任务）"),
    NO_CONTENT(204,"用户删除数据成功"),
    INVALID_REQUEST(400,"用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的"),
    UNAUTHORIZED(401,"表示用户没有权限（令牌、用户名、密码错误）"),
    FORBIDDEN(403,"表示用户得到授权（与401错误相对），但是访问是被禁止的"),
    NOT_FOUND(404,"用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。"),
    NOT_ACCEPTABLE(406,"用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。"),
    GONE(410,"用户请求的资源被永久删除，且不会再得到的。"),
    UNPROCESABLE_ENTITY(422,"当创建一个对象时，发生一个验证错误。"),
    INTERNAL_SERVER_ERROR(500,"服务器发生错误，用户将无法判断发出的请求是否成功。"),
    NO_ACCOUNT(434,"账号不存在"),
    NO_ENABLE(452,"黑名单"),
    WRONG_PASSWORD(438,"密码错误");

    private int state;

    private String stateInfo;
    ResponseInfo(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }
    public static ResponseInfo stateOf(int index){
        for(ResponseInfo state:values()){
            if(state.getState()==index){
                return state;
            }
        }
        return null;
    }



}