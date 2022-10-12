<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home" />
<html lang="en">
    <%@include file="head.jsp"%>
    <body>
        <div class="container">
            <%@include file="header.jsp"%>
            <div class="row">
                <div class="col-12 col-lg-6 py-1 px-5">
                    <div class="py-3">
                        <h3>Welcome to Honda Auto Parts</h3><br>
                        <p>This website is a where parts from multiple different
                            part sellers are combined into one. To make searching
                            for 6th gen Honda Civic parts and comparing prices
                            much easier. With an account you will not only be
                            able to search for parts, but you will be able to
                            save parts to your list of parts.</p>
                    </div>

                    <div class="text-center py-3 my-auto">
                        <c:if test="${user == null}" >
                            <a class="btn btn-success homepageButtons" href="signUp">Create An Account Now</a><br><br>
                            <p>OR</p>
                        </c:if>
                        <a class="btn btn-primary homepageButtons" href="#">Start Browsing Now</a>
                    </div>
                </div>
                <%--Image was found here https://wallpapercave.com/civic-ek-wallpapers--%>
                <div class="col-12 col-lg-6 py-3 my-auto">
                    <img class="w-100" src="images/Civic.jpg" alt="EK9 Honda Civic">
                </div>

            </div>
            <%@include file="footer.jsp"%>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
                integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
                integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    </body>
</html>
