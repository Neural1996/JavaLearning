package day03;/*
@date 2021/8/24-8:35
对象数组题目：
定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩
score(int)。 创建20个学生对象，学号为1到20，年级和成绩都由随机数确定。
问题一：打印出3年级(state值为3）的学生信息。
问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
提示：
1) 生成随机数：Math.random()，返回值类型double;
2) 四舍五入取整：Math.round(double d)，返回值类型long。

半个小时写出
*/


import java.util.Arrays;

public class Student {
    int number;
    int state;
    int score;
    //输出学生信息
    public void printStudent() {
        System.out.println("学号为" + number + "年级：" + state + "成绩：" + score);
    }
}
class StudentTest{
    /**
     * 冒泡排序
     * @param arr 要排序的student数组
     */
    public void sort(Student[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            Student temp;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].score > arr[j + 1].score) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = new Student[20];
        //创建好了对象数组后，一定要给每个数组元素new这个类的对象！！
        //要不然就是空指针错误
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
        for (int i = 0; i < students.length; i++) {
            students[i].number = i + 1;
            students[i].state = (int)(Math.random() * 4 + 1);
            students[i].score = (int)(Math.random() * 100);
        }
        for (int i = 0; i < students.length; i++) {
            if (students[i].state == 3){
                students[i].printStudent();
            }
        }
        System.out.println("***************************************");
        //讲冒泡排序封装在了StudentTest类中，所以想要调用sort就必须先要构造一个StudentTest的对象
        StudentTest stu = new StudentTest();
        stu.sort(students);
        for (int i = 0; i < students.length; i++) {
            students[i].printStudent();
        }
    }
}
