package by.it.rudzko._Project.java.controller;

interface Messages {
    String MESSAGE = "jsp_message";
    String MESSAGE_ERROR = "jsp_error";
    String OPTION_START = "<option value=\"";
    String OPTION_END = "</option>\n";
    String USER_NOT_FOUND = "User with such username and password doesn't exist";
    String ERROR_DATA = "Incorrect data. Please read hints and be attentive";
    String SUBSCRIBES = "<p>You subscribed to:</p>";
    String NO_SUBSCRIBES = "<p>Unfortunately, you haven't subscribed to any media yet.</>";
    String ADD_MEDIA_LINK = "<p><a href=\"do?command=Add\">ADD PERIODICAL</a></p>";
    String ERROR_DATABASE = "Database error";
    String INCORRECT_DATA = " doesn't match registration's conditions";
    String USER_EXISTS = "Such user exists. Please choose other username";
    String CANT_SUBSCRIBE = "Sorry, there're some problems with subscription. We're solving them right now. Please try later";
    String SUBSCRIBED = "You've already subscribed to that media";
    String LOG_IN_TO_START = "Please log in or create an account";
    String LOG_OUT = "Please log out";
    String CHOOSE_MEDIA = "Please choose any media";
    String NO_PAGE = "Page doesn't exist";
}
