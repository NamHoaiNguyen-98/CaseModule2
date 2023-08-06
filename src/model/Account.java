package model;

import java.io.Serializable;

public class Account implements Serializable {
        private static final long serialUID = 12345678;
        private String username;
        private String password;
        private boolean isLogin;

        public Account() {
        }
    public Account(String username, String password) {
        this.isLogin = false;
        this.username = username;
        this.password = password;
    }

        public boolean isLogin() {
            return isLogin;
        }

        public void setLogin(boolean login) {
            isLogin = login;
        }



        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return
                    "username='" + username
                    ;
        }
}
