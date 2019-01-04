package com.hwua.ssm.test;

import org.junit.Test;

import java.io.*;


public class ListFile {
    private int count=0;
    public int getCount()
    {
        return count;
    }

    public void listDir(String url) {
        File file=new File(url);
        if(!file.exists())
        {
            System.out.println("此路径不存在");
            return ;//程序不在就行执行
        }
        if(file.isDirectory())
        {
            //遍历目录下的所有文件及目录
            File[] files=file.listFiles();
            for(int i=0;i<files.length;i++)
            {
                //递归调用
                this.listDir(files[i].getAbsolutePath());
            }
        }
        else
        {
            //System.out.println(file.getAbsolutePath());
            //过滤文件，只输出.Java后缀的文件
            if(file.getAbsolutePath().endsWith(".java"))
            {
                System.out.println(file.getAbsolutePath());
                Reader r=null;
                BufferedReader br=null;
                try
                {
                    r=new FileReader(file);//读文件
                    br=new BufferedReader(r);//按行读文件
                    while(br.readLine()!=null)//统计文件的行数
                    {
                        this.count++;
                    }
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public static void main(String args[])
    {
        ListFile lf=new ListFile();
        lf.listDir("C:\\Program Files\\Java\\jdk1.8.0_91");
        System.out.println("已经写了"+lf.getCount()+ "行代码了");
        System.out.println("哈哈哈哈哈");
    }
}

