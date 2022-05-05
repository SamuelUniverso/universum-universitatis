package dev.asor.univitatis.view.gui.interfaces;

import java.util.List;

public interface FormTableInterface<E>
{
    void generateTable();
    
    void addElement(E object);
    
    void addDataOnTable(List<E> objects);
}
