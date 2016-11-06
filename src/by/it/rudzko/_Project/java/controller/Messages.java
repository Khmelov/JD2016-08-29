package by.it.rudzko._Project.java.controller;

interface Messages {
    String MESSAGE="jsp_message";
    String MESSAGE_ERROR="jsp_error";
    String OPTION_START = "<option value=\"";
    String OPTION_END = "</option>\n";
    String USER_NOT_FOUND = "User with such username and password doesn't exist.";
    String ERROR_DATA = "Incorrect data. Please read hints and be attentive.";
    String SUBSCRIBES = "<p>You subscribed to:</p>";
    String NO_SUBSCRIBES = "<p>Unfortunately, you haven't subscribed to any media yet.</>";
    String ADD_MEDIA_LINK = "<p><a href=\"do?command=Add\">ADD PERIODICAL</a></p>";
    String ERROR_DATABASE_CANT_ADD_USER = "Username and password each shoudn't be longer than 30 symbols. Please try once more.";
    String ERROR_DATABASE_CANT_ADD_PERI = "Title shouldn't be longer than 20 symbols. Please try once more.";
    String INCORRECT_DATA = " doesn't matches registration's conditions.";
    String USER_EXISTS = "Such user exists. Please choose other username.";
    String CANT_SUBSCRIBE = "Sorry, there're some problems with subscription. We're solving them right now. Please try later.";
    String SUBSCRIBED = "You've already subscribed to that media";
}
