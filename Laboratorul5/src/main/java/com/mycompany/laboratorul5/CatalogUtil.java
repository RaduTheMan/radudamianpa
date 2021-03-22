/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.laboratorul5;

import java.awt.Desktop;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.SAXException;


/**
 *
 * @author Radu
 */
public class CatalogUtil {
    public static void view(Item item)
    {
        Desktop desktop = Desktop.getDesktop();
        try
        {
        desktop.open(item.getFile());
        }
        catch(IOException e)
        {
            System.out.println("Unexpected error opening the file!");
            System.err.println(e);
        }
    }
    
    public static void saveWithBinary(Catalog catalog)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(catalog.getPath());
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(catalog);
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
    }
    
    public static void saveWithXML(Catalog catalog)
    {
        try 
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            
            String pathStr = catalog.getPath();
            String newPathStr = pathStr.replace(".ser", ".xml");
            catalog.setPath(newPathStr);
            
            Element root = document.createElement("catalog");
            document.appendChild(root);
            
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode(catalog.getName()));
            root.appendChild(name);
            
            Element path = document.createElement("path");
            path.appendChild(document.createTextNode(catalog.getPath()));
            root.appendChild(path);
            
            Element items = document.createElement("items");
            root.appendChild(items);
            
            List<Item> listItems = catalog.getItems();
            for(Item item : listItems)
            {
                Element itemElement = document.createElement(item.getInstanceType());
                Map <String, String> attributes = item.getAttrMap();
                for(var key : attributes.keySet())
                {
                    Element attribute = document.createElement(key);
                    attribute.appendChild(document.createTextNode(attributes.get(key)));
                    itemElement.appendChild(attribute);
                }
                items.appendChild(itemElement);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            DOMSource domSource = new DOMSource(document);
            
           
            StreamResult streamResult = new StreamResult(new File(newPathStr));
            transformer.transform(domSource, streamResult);
        } 
        catch (ParserConfigurationException | TransformerConfigurationException ex) 
        {
            System.err.println(ex);
        } catch (TransformerException ex) {
            System.err.println(ex);
        }
    }
        
    public static Catalog loadWithBinary(String path)
    {
        try
        {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fis);
        Catalog catalog = (Catalog)in.readObject();
        return catalog;
        }
        catch(FileNotFoundException e)
        {
            System.err.println(e);
        }
        catch(IOException e)
        {
            System.err.println(e);
        }
        catch(ClassNotFoundException e)
        {
            System.err.println(e);
        }
        return null;
    }
    
    public static Catalog loadWithXML(String path)
    {
        try
        {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(path);
            
            Node root = document.getChildNodes().item(0);
            NodeList catalogAttributes = root.getChildNodes();
            
            int listLength = catalogAttributes.getLength();
            String name="default", pathStr="default";
            for(int i=0; i<listLength;++i)
            {
                Node node = catalogAttributes.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE)
                {
                    switch(node.getNodeName())
                    {
                        case "name":
                            name = node.getFirstChild().getNodeValue();
                            break;
                        case "path":
                            pathStr = node.getFirstChild().getNodeValue();
                            
                            break;
                        case "items":
                            break;
                    }
                }
            }
            Catalog catalog = new Catalog(name,pathStr);
            return catalog;
            
        } 
        catch (ParserConfigurationException | SAXException | IOException ex) 
        {
            System.err.println(ex);
        }
        return null;
    }
}
