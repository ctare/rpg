package core.system;

import java.io.*;
import java.util.Locale;

/**
 * Created by ctare on 2016/10/31.
 */
public class NullOutputStream extends PrintStream{
    public NullOutputStream() {
        super(new OutputStream() {
            @Override
            public void write(int b) throws IOException {

            }
        });
    }

    @Override
    public void print(boolean b) {
    }

    @Override
    public void print(char c) {
    }

    @Override
    public void print(int i) {
    }

    @Override
    public void print(long l) {
    }

    @Override
    public void print(float f) {
    }

    @Override
    public void print(double d) {
    }

    @Override
    public void print(char[] s) {
    }

    @Override
    public void print(String s) {
    }

    @Override
    public void print(Object obj) {
    }

    @Override
    public void println() {
    }

    @Override
    public void println(boolean x) {
    }

    @Override
    public void println(char x) {
    }

    @Override
    public void println(int x) {
    }

    @Override
    public void println(long x) {
    }

    @Override
    public void println(float x) {
    }

    @Override
    public void println(double x) {
    }

    @Override
    public void println(char[] x) {
    }

    @Override
    public void println(String x) {
    }

    @Override
    public void println(Object x) {
    }

    @Override
    public PrintStream printf(String format, Object... args) {
        return this;
    }

    @Override
    public PrintStream printf(Locale l, String format, Object... args) {
        return this;
    }
}
