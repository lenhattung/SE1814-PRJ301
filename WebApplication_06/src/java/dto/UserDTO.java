/*
DTO (Data Transfer Object):
DTO là một design pattern dùng để đóng gói và truyền dữ liệu giữa các thành phần/layer trong ứng dụng
Là một class đơn giản chỉ chứa các thuộc tính (properties) và các phương thức getter/setter
Không chứa bất kỳ business logic nào
Mục đích chính là đóng gói dữ liệu để truyền qua network hoặc giữa các layer

Thường được sử dụng để:
Map dữ liệu từ database sang object
Truyền dữ liệu giữa client và server
Tối ưu số lượng request/response
 */
package dto;

/**
 *
 * @author tungi
 */
public class UserDTO {
    private String userID;
    private String fullName;
    private String roleId;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String roleId, String password) {
        this.userID = userID;
        this.fullName = fullName;
        this.roleId = roleId;
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
