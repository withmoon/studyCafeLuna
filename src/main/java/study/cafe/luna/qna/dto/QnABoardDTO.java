package study.cafe.luna.qna.dto;


import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class QnABoardDTO {
   private int num;
   private String subject;
   private String content;
   private Date regdate;

   public int getNum() {
      return num;
   }

   public void setNum(int num) {
      this.num = num;
   }

   public String getSubject() {
      return subject;
   }

   public void setSubject(String subject) {
      this.subject = subject;
   }

   public String getContent() {
      return content;
   }

   public void setContent(String content) {
      this.content = content;
   }

   public Date getRegdate() {
      return regdate;
   }

   public void setRegdate(Date regdate) {
      this.regdate = regdate;
   }

   @Override
   public String toString() {
      return "AdminQnABoardVO [num=" + num + ", subject=" + subject + ", content=" + content + ", regdate=" + regdate
            + "]";
   }

   
}