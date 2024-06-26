/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package views;

import com.dao.CategoriaDAO;
import com.dao.ClienteDAO;
import com.dao.ProductoDAO;
import controller.CategoriaController;
import controller.ClienteController;
import controller.ProductoController;

import java.util.Scanner;
import javax.swing.JFrame;

/**
 *
 * @author USUARIO
 */
public class main {
    public static void main(String[] args) {

                /*CategoriaVista view = new CategoriaVista();
                CategoriaDAO catDao = new CategoriaDAO();
                CategoriaController catecontroller = new  CategoriaController(view, catDao);
               
                JFrame frame = new JFrame("Biblioteca");
                frame.getContentPane().add(view);
                frame.pack();
                frame.setVisible(true);
                
                frame.setLocationRelativeTo(null);*/
                
                
               /*ClienteVista view = new ClienteVista ();
               ClienteDAO cliente = new ClienteDAO();
               ClienteController controler = new ClienteController(view, cliente);
               
                JFrame frame = new JFrame("Biblioteca");
                frame.getContentPane().add(view);
                frame.pack();
                frame.setVisible(true);
                
                frame.setLocationRelativeTo(null);*/
               
               
               ProductoVista view  = new ProductoVista ();
               ProductoDAO dao = new ProductoDAO();
               ProductoController controler = new ProductoController(dao, view);
               
                JFrame frame = new JFrame("Biblioteca");
                frame.getContentPane().add(view);
                frame.pack();
                frame.setVisible(true);
                
                frame.setLocationRelativeTo(null);
                
        }
    }
