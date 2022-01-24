package edu.bu.jkrovitz.console.enums;

public enum Role {

    ADMIN {
        @Override
        public String toString(){
            return "administrator";
        }
    },

    LIBRARIAN {
        @Override
        public String toString(){
            return "librarian";
        }
    },

    LIBRARY_CLERK {
        @Override
        public String toString(){
            return "library clerk";
        }
    },

    PATRON {
        @Override
        public String toString(){
            return "patron";
        }
    }
}
