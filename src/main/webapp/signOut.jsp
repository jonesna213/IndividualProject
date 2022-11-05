<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Sign Out" />
<c:if test="${user == null}" >
    <c:redirect url = "index.jsp"/>
</c:if>
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="w-50 mx-auto text-center">
                <h2>Are you sure you want to sign out?</h2>
                <br>
                <form action="signOut" method="get">
                    <input class="btn btn-success mx-2 p-3" type="submit" name="choice" value="Sign Out"/>
                    <input class="btn btn-danger mx-2 p-3" type="submit" name="choice" value="Dont Sign Out"/>
                </form>
                <br>
            </div>
            <%@include file="footer.jsp"%>
        </div>
        <%@include file="bootstrapFiles.jsp"%>
    </body>
</html>
