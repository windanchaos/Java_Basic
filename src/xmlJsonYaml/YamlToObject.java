package xmlJsonYaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


/*
yaml文件序列化、反序列化

 */
public class YamlToObject {
    public static void main(String[] args) {
        toJson();
        toObject();
    }

    public static void toJson(){
        Boss boss = new Boss("我","18781901170","延边大学");
        Leader leader = new Leader(1,"和尚");
        ArrayList<Department> listdepartment= new ArrayList<>();
        listdepartment.add(new Department(1,"总部",leader));
        Company company = new Company("波江科技",boss,listdepartment);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            System.out.println(mapper.writeValueAsString(company));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
    public static void toObject(){
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            FileInputStream stream =new FileInputStream(new File("D:\\Code\\Java_Basic\\src\\xmlJsonYaml\\company.yaml"));
            Company commpany = mapper.readValue(stream, Company.class);
            System.out.println(commpany.getBoss().getName());
            System.out.println(commpany.getDepartments().get(0).getName());
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }
}
}

class Company{
    @JsonProperty
    String name;
    @JsonProperty
    Boss boss;
    @JsonProperty
    ArrayList<Department> departments;

    public Company(){}
    public Company(String name, Boss boss, ArrayList<Department> departments) {
        this.name = name;
        this.boss = boss;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}
class Boss{
    @JsonProperty
    String name;
    @JsonProperty
    String phone;
    @JsonProperty
    String school;
    //一定要有显示的无参数构造函数
    public Boss(){}
    public Boss(String name, String phone, String school) {
        this.name = name;
        this.phone = phone;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
class Leader{
    @JsonProperty
    Integer id;
    @JsonProperty
    String name;
    public Leader(){}
    public Leader(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Department{
    @JsonProperty
    Integer id;
    @JsonProperty
    String name;
    @JsonProperty
    Leader leader;
    public Department(){}
    public Department(Integer id, String name, Leader leader) {
        this.id = id;
        this.name = name;
        this.leader = leader;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}

