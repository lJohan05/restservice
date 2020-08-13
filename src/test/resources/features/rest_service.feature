Feature: Register user through api

  @RegistrationUser
  Scenario Outline: Registration user
    Given Candidate create a user with the post method in "https://gorest.co.in/"
    When Candidate provide information the post method with "public-api/users"
      | first_name   | last_name   | gender   | email   | status   |
      | <first_name> | <last_name> | <gender> | <email> | <status> |
    Then Johan verify the creation of this user with the get method

    Examples:
      | first_name | last_name | gender | email                 | status |
      | Johan      | Miranda   | male   | johanmiranda@mail.com | active |
