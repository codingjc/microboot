package cn.codingjc.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author coding_jc
 * @date 2021/8/14
 */
@Data // 本身不会产生构造（默认的无参构造）
@NoArgsConstructor
public class Dept {

    @NonNull  // 该属性不允许为空
    private Long deptno;
    @NonNull
    private String name;
    private String loc;
}
