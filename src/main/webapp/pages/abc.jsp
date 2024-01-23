<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    
     
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
     <div class="container">
      <h1 class="pb-3 pt-3" style="text-align: center;">REPORT DETAIS</h1>
    
      <form:form action="search" modelAttribute="search" method="POST">
   
      <table class="border border-5 d-flex p-3 justify-content-around">

            <tr>
            
            	<td>plan-name:</td>
            	<td>
            	     <form:select path="planName"> 
            	           <form:option value="">-select-</form:option>
            	           <form:options items="${plans}"/>
            	      </form:select>
            	</td>
            
               
            	<td>plan-status:</td>
            	<td>
            	     <form:select path="planStatus"> 
            	           <form:option value="">-select-</form:option>
            	           <form:options items="${status}"/>
            	      </form:select>
            	</td>

                
            	<td>gender:</td>
            	<td>
            	     <form:select path="gender"> 
            	           <form:option value="">-select-</form:option>
            	           <form:option value="male">male</form:option>
            	           <form:option value="female">female</form:option>
            	      </form:select>
            	</td>
           </tr>
           <tr>
                
              <td>Start date:</td>
              <td><form:input path="startDate" type="date" /> </td>
              <td>end date:</td>
              <td><form:input path="endDate" type="date" /> </td>
           </tr>
           <tr>
           		<td>
           		        <a href="/" class="btn btn-secondary">RESET</a>
           		 </td>
           		 <td>       
           		        <input type="submit" value="search" class="btn btn-primary">
         			</td>	
         		 
          </tr>
            
      </table>
    
      </form:form>
      
     
      <hr>
      
      <table class="table table-hover">
            <thead>
                 <tr>
                     <th>sno</th>
                     <th>Holder name</th>
                     <th>plan name</th>
                     <th>gender</th>
                     <th>plan status</th>
                     <th>start date</th>
                     <th>end date</th>
                     <th>benifitAmount</th>
                     <th>denialReason</th>
                     <th>terminationDate</th>
                     <th>terminationReason</th>
                     
                 </tr>
            </thead>
            <tbody>
                 <c:forEach items="${plns}" var="plan" varStatus="index">
                      <tr>
                          <td>${index.count}</td>
                          <td>${plan.CITIZEN_NAME}</td>
                          <td>${plan.PLAN_NAME}</td>
                           <td>${plan.GENDER}</td>
                          <td>${plan.PLAN_STATUS}</td>
                          <td>${plan.PLAN_START_DATE}</td>
                          <td>${plan.PLAN_END_DATE}</td>
                          <td>${plan.BENEFIT_AMOUNT}</td>
                          <td>${plan.DENIAL_REASON}</td>
                          <td>${plan.TERMINATED_DATE}</td>
                          <td>${plan.TERMINATION_REASON}</td>
                         
                      </tr>
                  </c:forEach>
                  <tr>
                       <c:if test="${empty plns}">
                             <td colspan="12" style="text-align: center;">NO RECORD FOUND</td>
                       </c:if>
                  </tr>
                    
            </tbody>
      </table>
           
      <hr>
        
        <h3>export</h3>
        <a href="excel" class="btn btn-outline-primary">excel</a>&nbsp;&nbsp;
        <a href="pdf" class="btn btn-outline-primary">pdf</a>
      </div>
      
      
      <div class="card text-center">
 
           <div class="card-footer text-muted">
                    <h3>contact us</h3><br>
                    <p>korapatitharunraj@gmail.com</p>
          </div>
     </div>
</body>
</html>