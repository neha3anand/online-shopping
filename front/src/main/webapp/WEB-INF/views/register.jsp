<div class="row">

	<div class="col-lg-12">

<form:form modelAttribute="user" action="${contextRoot}/register" class="form-horizontal" method="post">
<fieldset>

<!-- Form Name -->
<legend>Personal Information</legend>
<span style="color:red">${msg}</span>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="First Name">First Name</label>  
  <div class="col-md-4">
  <form:input path="firstName" name="First Name" type="text" placeholder="placeholder" class="form-control input-md"/>
  <span class="help-block">help</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Last Name</label>  
  <div class="col-md-4">
  <form:input path="lastName" name="textinput" type="text" placeholder="placeholder" class="form-control input-md"/>
  <span class="help-block">help</span>  
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password </label>
  <div class="col-md-4">
    <form:password path="password" name="passwordinput" placeholder="placeholder" class="form-control input-md"/>
     <span class="help-block">help</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Confirm Password</label>
  <div class="col-md-4">
    <form:input path="confirmPassword" name="passwordinput" type="password" placeholder="placeholder" class="form-control input-md"/>
    <span class="help-block">help</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Contact Number</label>  
  <div class="col-md-4">
  <form:input path="contactNumber" name="textinput" type="text" placeholder="placeholder" class="form-control input-md"/>
  <span class="help-block">help</span>  
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Email</label>  
  <div class="col-md-4">
  <form:input path="email" name="textinput" type="text" placeholder="placeholder" class="form-control input-md"/>
  <span class="help-block">help</span>  
  </div>
</div>

<input type="submit" class="btn btn-success" value="Save">
<input type="reset" class="btn btn-danger" value="Cancel">

</fieldset>
</form:form>
</div>
</div>

