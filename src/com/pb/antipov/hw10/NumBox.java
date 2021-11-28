package com.pb.antipov.hw10;

public class NumBox<T extends Number> {
    private T[] numbers;

    //конструктор
    public NumBox(int size) {
       this.numbers = (T[]) new Number[size];
    }

    //- метод T get(int index) возвращающий число по индексу.
    public T get(int index) {
        return numbers[index];
    }

    //- метод int length() возвращает текущее количество элементов.
    public int length() {
        int l = 0;
        for (T num: numbers) {
            if(num != null){
                l++;
            }
        }
        return l;
    }

    //- метод void add(T num) добавляющий число в массив. В случае если массив полон - выбросить исключение.
    public void add(T num) throws Exception{
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i] == null){
                numbers[i] = num;
                break;
            } else if(i == numbers.length - 1 && numbers[i] != null) {
                throw new FullArrayException("Не удалось добавить новый элемент массива. Массив содержит максимальное количество элементов ");
            }
        }
    }

    //- метод double average() - подсчет среднего арифметического среди элементов массива.
    public double average() throws EmptyArrayException {
        double d = 0;
        int count = 0;
        for (T num: numbers) {
            if(num != null){
                d += num.doubleValue();
                count++;
            }
        }
        if (count != 0) return d/count;
        else throw  new EmptyArrayException("Массив не содержит элементов");
    }

    //- метод double sum() - сумма всех элементов массива.
    public double sum(){
        double d = 0;
        for (T num: numbers) {
            if(num != null){
                d += num.doubleValue();
            }
        }
        return d;
    }

    //- метод T max() - максимальный элемент массива.
    public T max(){
        T max = numbers[0];
        for (T num: numbers) {
            if(num != null && num.doubleValue() > max.doubleValue()){
                max = num;
            }
        }
        return max;
    }
}

class FullArrayException extends Exception{
    public FullArrayException(String message) {
        super(message);
    }
}

class EmptyArrayException extends Exception{
    public EmptyArrayException(String message) {
        super(message);
    }
}
