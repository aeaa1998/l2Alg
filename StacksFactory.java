

import java.util.ArrayList;

public class StacksFactory<T> {
    private ArrayList<String> validTypes = new ArrayList<>();
    private ArrayList<String> validLists = new ArrayList<>();
    private View view;

    public StacksFactory(View view) {
        validTypes.add("Vector");
        validTypes.add("ArrayList");
        validTypes.add("Lista");

        validLists.add("Circular");
        validLists.add("Link Simple");
        validLists.add("Link Doble");
        this.view = view;
    }

    public iStack<T> create(){
        var c = view.selectOptions(validTypes, "Ingrese el tipo de stack que desea", "Ingrese un numero valido");
        switch (c){
            case 0:
                return new VectorStack<>();
            case 1:
                return new ArrayListStack<>();
            case 2:
                switch (view.selectOptions(validLists, "Ingrese el tipo de lista que desea", "Ingrese un numero valido")) {
                    case 0:
                        return new CircularListStack<>();
                    case 1:
                        return new SinglyLinkedListStack<>();
                    case 2:
                        return new DoublyLinkedListStack<>();
                }
        }
        return null;
    }
}
