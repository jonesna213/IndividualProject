<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="View Profile" />
<c:if test="${user == null}" >
    <c:redirect url = "index.jsp"/>
</c:if>
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="w-50 mx-auto">
                <h2 class="text-decoration-underline">View Profile</h2>
                <c:if test="${error != null}" >
                    <c:if test="${error == true}" >
                        <h3 class="text-danger">Failed to edit profile, please try again</h3>
                        <p>${message}</p>
                    </c:if>
                    <c:if test="${error == false}" >
                        <h3 class="text-success">Profile edit was successful</h3>
                    </c:if>
                    <c:remove var="error" scope="session"/>
                </c:if>
                <form action="editProfileServlet" method="post" id="editProfileForm">
                    <p class="text-danger">ALL fields are Required</p>
                    <div class="form-group my-3">
                        <label for="firstName" class="fw-bold">First Name</label>
                        <input type="text" class="form-control"
                               name="firstName" id="firstName" value="${user.firstName}"/>
                    </div>
                    <div class="form-group my-3">
                        <label for="lastName" class="fw-bold">Last Name</label>
                        <input type="text" class="form-control"
                               name="lastName" id="lastName" value="${user.lastName}"/>
                    </div>
                    <div class="form-group my-3">
                        <label for="email" class="fw-bold">Email</label>
                        <input type="email" class="form-control"
                               name="email" id="email" value="${user.email}"/>
                    </div>
                    <div class="form-group my-3">
                        <label for="username" class="fw-bold">Username</label>
                        <input type="text" class="form-control"
                               name="username" id="username" placeholder="${user.username}" readonly/>
                    </div>
                    <div class="mx-auto">
                        <input class="btn btn-success" type="submit" value="Submit Profile Change"/>
                    </div>
                </form>
            </div>
            <%@include file="footer.jsp"%>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
