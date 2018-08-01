package javaImooc.javaJSON;


public enum Status {
    // 1XX Infomational
    CONTINUE(100),
    PROCESSING(102),
    CHECKPOINT(103),

    // 2XX Success
    OK(200),
    CREATED(201),
    ACCEPTED(203),

    // 3XX Redirection
    FOUND(302),

    // 4XX Client Error
    UNAUTHORIZED(401),
    CONFLICT(409),
    GONE(410),;

    private int code;

    Status(int code) {
        this.code = code;
    }


}
