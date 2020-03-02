package com.board.web.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckImgServlet
 */
@WebServlet("/CheckImgServlet")
public class CheckImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int width=150;
		int height=42;
		BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
		Graphics graphics=bufferedImage.getGraphics();
		graphics.setColor(Color.YELLOW);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.BLUE);
		graphics.drawRect(0, 0, width-1, height-1);
		Graphics2D g2d=(Graphics2D)graphics;
		g2d.setColor(Color.BLACK);
		g2d.setFont(new Font("宋体",Font.BOLD,18));
		String words="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random=new Random();
		//定义一个字符串，用于保存随机产生的四个字母或者数字
		StringBuffer sb=new StringBuffer();
		int x=10;
		for(int i=0;i<4;i++) {
			int idx=random.nextInt(words.length());
			//获得指定位置的字符
			char ch=words.charAt(idx);
			//把字符存入到stringbuffer中
			sb.append(ch);
			//旋转角度-30--+30
			int jiaodu=random.nextInt(60)-30;
			//角度转成弧度
			double theta=jiaodu*Math.PI/180;
			g2d.rotate(theta, x, 20);
			g2d.drawString(String.valueOf(ch),x , 20);
			g2d.rotate(-theta, x, 20);
			x+=30;
		}
		//将产生的字符串存入到session
		request.getSession().setAttribute("checkcode", sb.toString());
		ImageIO.write(bufferedImage, "jpg", response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
