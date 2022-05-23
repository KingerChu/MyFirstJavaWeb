package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@WebServlet(urlPatterns = "/checkcode")
public class CheckCode extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedImage p=new BufferedImage(100,50,BufferedImage.TYPE_INT_BGR);
        Graphics g=p.getGraphics();
        // 设置颜色
        g.setColor(Color.WHITE);
        // 填充区域
        g.fillRect(0, 0, 100, 50);
        // 设置边框颜色
        g.setColor(Color.BLUE);
        // 边框区域
        g.drawRect(1, 1, 100 - 2, 50 - 2);

        // 设置线条个数并画线
        for (int i = 0; i < 10; i++) {
            Random random=new Random();
            int r=random.nextInt(255);
            int ge=random.nextInt(255);
            int b=random.nextInt(255);
            // 设置颜色
            g.setColor(new Color(r,ge,b));
            int x1 = random.nextInt(100);
            int y1 = random.nextInt(50);
            int x2 = random.nextInt(100);
            int y2 = random.nextInt(50);
            g.drawLine(x1, y1, x2, y2);
        }
        StringBuffer sb = new StringBuffer();
        Random random=new Random();
        int x = 10;
        String ch ="";
        // 控制字数
        for (int i = 0; i < 4; i++) {
            // 设置字体旋转角度
            int degree = new Random().nextInt() % 30;
            ch = new Random().nextInt(9) + "";
            // 正向角度
            Graphics2D gg=(Graphics2D)g;
            gg.rotate(degree * Math.PI / 180, x, 20);
            int r=random.nextInt(255);
            int ge=random.nextInt(255);
            int b=random.nextInt(255);
            Font f = new Font(null,Font.PLAIN,25);
            g.setFont(f);
            // 设置颜色
            g.setColor(new Color(r,ge,b));
            gg.drawString(ch, x, 35);
            sb.append(ch);
            // 反向角度
            gg.rotate(-degree * Math.PI / 180, x, 20);
            x += 20;
        }
        String code= sb.toString();
//        System.out.println(sb);
//        ServletContext context=this.getServletContext();
        req.getSession().setAttribute("checkcode",code);
//        req.getSession().setAttribute("checknum",code);



//        resp.sendRedirect("https://www.baidu.com");//重定向
        ImageIO.write(p,"jpg", resp.getOutputStream());
    }
}
