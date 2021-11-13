//Gireesh Sharma-Singh N01193783
//Zhiyuan Hua N01406966
// Brett Kean N01158642
//Eghe Iyobosa N01107171
//Supriya N01394695
//////////////////////////////////
package ca.aceapps.it.feelgood;

public class User {
    public String fullName, age, gender, email, password;


    public User() {

    }


    public User(String fullName, String age, String gender, String email, String password) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.password = password;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
