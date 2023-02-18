<%@page import="Com.db_controller.Patient" %>   

        <%
           String str = (String) request.getAttribute("User");
           String ago = (String) request.getAttribute("Years");
           Patient user = new Patient(str);
           String[] n = user.getName().split("-");
           String name = n[0] + " " + n[1];
        %>

            <div class="container">
                <div class="main-body">
                    <div class="row" style="margin-top: 15vh;">
                        <div class="col-lg-4">
                            <div class="card">
                                <div class="card-body">
                                    <div class="d-flex flex-column align-items-center text-center">
                                        <img src="Assets/avatar7.png" alt="Admin" class="rounded-circle" width="150">
                                        <div class="mt-3">
                                             <br>
                                                <form action="logout" method="post">
                                                    <h4> <%=name %> </h4>
                                                    <p class="text-secondary mb-1"><%=ago%>/ <%=user.getGender()%></p>
                                                    <p class="text-muted font-size-sm"><%=user.getEmailId()%></p>
                                                    <button class="btn btn-primary">Message</button>
                                                    <input hidden name="logout" value="out">
                                                    <button class="btn btn-outline-primary" type="submit">Logout</button>
                                                </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="card">
                                <div class="card-body">
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">Full Name  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" value="<%=name %>">
                                        </div>
                                    </div>
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">D.O.B  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="date" name="Dob" value="<%=user.getDob()%>" required>
                                        </div>
                                    </div>
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">Age / Gender  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" value="<%=ago%>/ <%=user.getGender()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">Blood Group  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" value="<%=user.getBloodGroup()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">Email  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input readonly type="text" class="form-control" value="<%=user.getEmailId()%>">
                                        </div>
                                    </div>
                                    <div class="row mb-3" style="margin-bottom: 10px;">
                                        <div class="col-sm-3">
                                            <h5 class="mb-0">Address  : </h5>
                                        </div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="text" class="form-control" value="Bay Area, San Francisco, CA">
                                        </div>
                                    </div>
                                    <div style="height: 20px;">
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-3"></div>
                                        <div class="col-sm-9 text-secondary">
                                            <input type="button" class="btn btn-primary px-4" value="Save Changes">
                                            <a href="profile"><input type="button" class="btn btn-outline-primary" value="Cancel"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

</div>
</div>
</body>
</html>