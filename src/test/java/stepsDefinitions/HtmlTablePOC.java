package stepsDefinitions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HtmlTablePOC {


    public static void main(String[] args) throws IOException {

        Map<String, String> map = new HashMap<>();
        map.put("column1", "TestName1");
        map.put("column2", "TestName2");
        map.put("column3", "TestName3");


        // Store map values into the list

        List<String> collect = map.values().stream().collect(Collectors.toList());

        List<String> list1 = Arrays.asList("10", "20", "30");
        List<String> list2 = Arrays.asList("100", "200", "300");
        List<String> list3 = Arrays.asList("1000", "200", "300");


        StringBuilder build = new StringBuilder();
       /* build.append("<html>"+
        """
             <head>
      <style>
         table, th, td {
            border: 1px solid black;
         }
      </style>
   </head>
                """
                        + "<body>" + "<table>" + "<tr>" + "<th>column1</th>" + "<th>column2</th>" + "<th>column3</th>" + "<th>column4</th>" + "<th>column5</th>" + "<th>column6</th>" + "</tr>");
*/

        build.append("""
                <!DOCTYPE html>
                <html>
                <head>
                <style>  
                table{  
                border-collapse: collapse;  
                width: 50%;   
                }  
                th,td{  
                border: 2px solid black;   
                padding: 15px;  
                } 
                .hide {
                display: none;
                } 
                .myDIV:hover + .hide {
                display: block;
                color: red;
               }     
                </style>  
                </head>
                <body>
                <h2>HTML Table</h2>
                <table>
                <tr>
                <th>column1</th>
                <th>column2</th>
                <th>column3</th>
                </tr>
                """);


        for (int i = 0; i < map.size(); i++) {

            build.append("<tr><td>").append(collect.get(i)+" ").append("""
                    <div class="myDIV">DB Values</div>
                    <div class="hide">A B C</div>
                    """).append("</td><td>").append(list1.get(i)).append("</td><td>").append(list2.get(i)).append("</td><td>");

        }
        build.append("</table>" + "</body>" + "</html>");
        System.out.println(build);
        Files.writeString(Path.of("./target/htmlReport.html"), build);

    }

}
