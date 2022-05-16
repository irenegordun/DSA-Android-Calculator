package com.example.eduupcdsacalculadora;
import android.content.Context;
import androidx.test.*;
import org.junit.*;

import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.eduupcdsacalculadora", appContext.getPackageName());
    }
}
