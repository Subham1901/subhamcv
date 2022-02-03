<form id="contactForm" action="SendTome">
  <p><%@include file="message.jsp" %></p> 
        <div class="row">
          <div class="col-md-6">
            <div class="form-group">
              <input required type="text" id="name" name="name" class="form-control" placeholder="Name" required="required">
              <p class="help-block text-danger"></p>
            </div>
          </div>
          <div class="col-md-6">
            <div class="form-group">
              <input required type="email" id="email" name="mail" class="form-control" placeholder="Email" required="required">
              <p class="help-block text-danger"></p>
            </div>
          </div>
        </div>
        <div class="form-group">
          <textarea style="max-width: 445px;"  required name="message" id="message" name="message" class="form-control" rows="4" placeholder="Message" required></textarea>
          <p class="help-block text-danger"></p>
        </div>
        <div id="success"></div>
        <button type="submit" class="btn btn-default btn-lg">Send Message</button>
      
      </form>