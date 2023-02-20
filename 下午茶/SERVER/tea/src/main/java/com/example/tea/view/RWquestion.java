package com.example.tea.view;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.tea.JavaClass.questionClass;
import com.example.tea.JavaClass.questionCommentClass;
import com.example.tea.server.GetPicture;
import com.example.tea.server.UserMapper;
import com.example.tea.server.questionCommentMapper;
import com.example.tea.server.questionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class RWquestion {
    @Autowired
    private questionMapper question;
    @Autowired
    private GetPicture getPicture;
    @Autowired
    private questionCommentMapper questionComment;
    @Autowired
    private UserMapper user;

    /*获取问题界面*/
    @RequestMapping(value = "/readQuestion")
    public String ReadQuestion(HttpServletRequest request)
    {
        try{
            Cookie[] cookies = request.getCookies();
            String account=null;
            String password=null;
            int n=0;
            if(cookies!=null)
            {
                for(Cookie cookie:cookies)
                {
                    if(n==0)
                    {
                        account=cookie.getValue();
                        n++;
                    }
                    else
                    {
                        password=cookie.getValue();
                    }
                }
            }
            String Username = user.getName(account,password);
            String name=request.getParameter("question");
            int id = Integer.parseInt(name);
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",Username);
            Map map = question.GetQuestion(id);
            jsonObject.put("title",map.get("title"));
            String address1 = getPicture.getPicture((String)map.get("picture1"));
            String address2=getPicture.getPicture((String)map.get("picture2"));
            String address3=getPicture.getPicture((String)map.get("picture3"));
            String address4=getPicture.getPicture((String)map.get("picture"));
            if(!map.get("picture1").equals("null"))
            {
                jsonObject.put("picture1",address1);
            }
            else
            {
                jsonObject.put("picture1","https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            }
            if(!map.get("picture2").equals("null"))
            {
                jsonObject.put("picture2",address2);
            }
            else
            {
                jsonObject.put("picture2","https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            }
            if(!map.get("picture3").equals("null"))
            {
                jsonObject.put("picture3",address3);
            }
            else
            {
                jsonObject.put("picture3","https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            }
            if(!map.get("picture4").equals("null"))
            {
                jsonObject.put("picture4",address4);
            }
            else
            {
                jsonObject.put("picture4","https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
            }
            return jsonObject.toJSONString();
        }catch (Exception e)
        {
               return "false";
        }
    }
/*获取评论*/
    @RequestMapping(value = "/questionComment1")
    public String GetQuestionComment(HttpServletRequest request)
    {

        try{
            String id = request.getParameter("question");
            int Id = Integer.parseInt(id);
            List<Map<String,Object>> list=questionComment.GetQuestion(Id);
            JSONObject jsonObject =new JSONObject();
            int i=0;
            for(Map map :list)
            {
                List list1 =new ArrayList();
                list1.add(map.get("UserName"));
                list1.add(map.get("content"));
                list1.add(map.get("num"));
                list1.add(map.get("id"));
                jsonObject.put("question"+i,list1);
                i++;
            }
            return jsonObject.toJSONString();
        }
        catch (Exception e)
        {
            return "false";
        }
    }
    /*添加评论*/
    @RequestMapping(value = "/questionComment2")
    public void SetQuestionComment(@RequestBody String data)
    {
        try{
            questionCommentClass comment = JSON.parseObject(data,questionCommentClass.class);
            questionComment.SetQuestion(comment.getName(),comment.getContent(),comment.getQuestion());
        }
        catch (Exception e)
        {

        }
    }

    /*上传问题*/
    @RequestMapping(value = "/uploadQuestion")
    public String uploadQuestion(@RequestBody String data)
    {
        try{
            questionClass questionclass = JSON.parseObject(data,questionClass.class);
            if(questionclass.getPicture().equals("null"))
            {
                String picture="null";
                question.SetQuestion(questionclass.getTitle(),questionclass.getName(),questionclass.getDate(),picture);
            }
            else
            {
                String picture = questionclass.getPicture().substring((questionclass.getPicture().indexOf(",")+1));
                byte[] photo = Base64.getDecoder().decode(picture);
                String pictureName=questionclass.getTitle()+".jpg";
                String address = getPicture.SetPicture(pictureName);
                OutputStream out = new FileOutputStream(address);
                out.write(photo);
                out.flush();
                out.close();
                question.SetQuestion(questionclass.getTitle(),questionclass.getName(),questionclass.getDate(),pictureName);
            }
            return "1";
        }
        catch (Exception e)
        {
            return "0";
        }


    }
}
