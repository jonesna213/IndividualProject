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
                <c:if test="${noZip != null}" >
                    <c:if test="${noZip == true}" >
                        <h2 class="text-decoration-underline">Please enter your zip code</h2>
                        <c:if test="${zipError == true}" >
                            <h3 class="text-danger">Please enter a valid zip code</h3>
                            <c:remove var="zipError" scope="session"/>
                        </c:if>
                            <form action="addZipCodeServlet" method="post" id="editProfileForm">
                                <div class="form-group my-3">
                                    <label for="zip" class="fw-bold">Zip Code</label>
                                    <input type="text" class="form-control"
                                           name="zip" id="zip" />
                                </div>
                                <div class="mx-auto">
                                    <input class="btn btn-success" type="submit" value="Submit"/>
                                </div>
                            </form>
                    </c:if>
                </c:if>
                <c:if test="${noZip == null}" >
                    <h2 class="text-decoration-underline">View Profile</h2>
                    <c:if test="${error != null}" >
                        <c:if test="${error == true}" >
                            <h3 class="text-danger">Failed to edit profile, please try again</h3>
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
                        <c:if test="${zipError == true}" >
                            <h3 class="text-danger">Please enter a valid zip code</h3>
                            <c:remove var="zipError" scope="session"/>
                        </c:if>
                        <div class="form-group my-3">
                            <label for="zip" class="fw-bold">Zip Code</label>
                            <input type="text" class="form-control"
                                   name="zip" id="zip" value="${user.zip}"/>
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
                </c:if>
            </div>
            <%@include file="footer.jsp"%>
        </div>
        <%@include file="bootstrapFiles.jsp"%>
    </body>
</html>
