<%-- 
    Document   : home
    Created on : Aug 2, 2015, 9:14:54 PM
    Author     : Marrows
--%>
<jsp:useBean id="customers1" class="appointment.data.ObjectFactory" />
<div class="mdl-card mdl-shadow--2dp demo-card-wide" style="margin-left: auto; margin-right: auto; margin-top: 15px;">
    <form name="form1" action="index.jsp?page=response" method="post">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Hello World!</h2>
        </div>
        <div class="mdl-card__supporting-text">
            First Name: <input type="text" name="first_name">
            <br />
            Last Name: <input type="text" name="last_name" />
        </div>
        <input type="submit" value="submit" />
        <div class="mdl-card__actions mdl-card--border">
            <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect" href="index.html?name=response">
                Get Started
            </a>
        </div>
        <div class="mdl-card__menu">

            <button class="mdl-button mdl-button--icon mdl-js-button mdl-js-ripple-effect">
                <i class="material-icons">share</i>
            </button>
        </div>
    </form>
</div>