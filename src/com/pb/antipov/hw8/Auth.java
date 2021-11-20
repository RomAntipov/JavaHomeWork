package com.pb.antipov.hw8;

public class Auth {
    private String login;
    private String password;

    public Auth(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        signUp(login,password,confirmPassword);
    }

    private void signUp (String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if(login.matches("[a-zA-Z0-9]{5,20}")){
            if(password.matches("[a-zA-Z0-9_]{5,}") && password.equals(confirmPassword)){
                this.login = login;
                this.password = password;
                System.out.println("Регистрация прошла успешно.");
            } else if(!password.equals(confirmPassword)){
                throw new WrongPasswordException("Пароли не совпадают.");
            } else {
                throw new WrongPasswordException("Пароль не соответствует требованиям.");
            }
        } else {
            throw new WrongLoginException("Логин не соответствует требованиям.");
        }
    }

    public void signIn(String login, String password) throws WrongLoginException {
        if(login.equals(this.login)  && password.equals(this.password)) {
            System.out.println("Вход выполнен.");
        } else {
            throw new WrongLoginException("Неверный логин или пароль.");
        }


    }

     class WrongPasswordException extends Exception{
        public WrongPasswordException() {
        }

        public WrongPasswordException(String message) {
            super(message);
        }
    }

     class WrongLoginException extends Exception {

        public WrongLoginException() {
        }

        public WrongLoginException(String message) {
            super(message);
        }
    }
}
