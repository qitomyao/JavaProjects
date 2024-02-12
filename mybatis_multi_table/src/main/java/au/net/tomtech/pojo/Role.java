package au.net.tomtech.pojo;

import java.util.List;

// 封装role表的信息
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDetail;

    // 从角色角度，查询角色以及对应的用户信息
    private List<User> userList;


    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleDetail, List<User> userList) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDetail = roleDetail;
        this.userList = userList;
    }

    /**
     * 获取
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取
     * @return roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取
     * @return roleDetail
     */
    public String getRoleDetail() {
        return roleDetail;
    }

    /**
     * 设置
     * @param roleDetail
     */
    public void setRoleDetail(String roleDetail) {
        this.roleDetail = roleDetail;
    }

    /**
     * 获取
     * @return userList
     */
    public List<User> getUserList() {
        return userList;
    }

    /**
     * 设置
     * @param userList
     */
    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String toString() {
        return "Role{roleId = " + roleId + ", roleName = " + roleName + ", roleDetail = " + roleDetail + ", userList = " + userList + "}";
    }
}
