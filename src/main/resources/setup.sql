create user 'quizapp'@'localhost' identified by 'quizapp';

grant all privileges on *.* to 'quizapp'@'localhost';

create database `quiz-app`;
use `quiz-app`;


drop table if exists questions;
create table questions(
                          id int primary key auto_increment,
                          question text not null ,
                          opt_1 text not null ,
                          opt_2 text not null ,
                          opt_3 text not null ,
                          opt_4 text not null ,
                          correct_option text not null
);

insert into questions(question, opt_1, opt_2, opt_3, opt_4, correct_option)
values
('Which is used to find and fix bugs in the Java programs.?','JVM','JDB','JDK','JRE','JDB'),
('What is the return type of the hashCode() method in the Object class?','int','Object','long','void','int'),
('Which package contains the Random class?','java.util package','java.lang package','java.awt package','java.io package','java.util package'),
('An interface with no fields or methods is known as?','Runnable Interface','Abstract Interface','Marker Interface','CharSequence Interface','Marker Interface'),
('In which memory a String is stored, when we create a string using new operator?','Stack','String memory','Random storage space','Heap memory','Heap memory'),
('Which of the following is a marker interface?','Runnable interface','Remote interface','Readable interface','Result interface','Remote interface' ),
('Which keyword is used for accessing the features of a package?','import','package','extends','export','import'),
('In java, jar stands for?','Java Archive Runner','Java Archive','Java Application Resource','Java Application Runner','Java Archive'),
('Which of the following is a mutable class in java?','java.lang.StringBuilder','java.lang.Short','java.lang.Byte','java.lang.String','java.lang.StringBuilder'),
('Which of the following option leads to the portability and security of Java?','Bytecode is executed by JVM','The applet makes the Java code secure and portable','Use of exception handling','Dynamic binding between objects','Bytecode is executed by JVM');