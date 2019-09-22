package edu.utdallas.emse.hw1;

import edu.utdallas.emse.hw1.serialization.ObjectSerializable;
import edu.utdallas.emse.hw1.serialization.Serialized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Serialized(tag = "test-serializer")
public class TestSerializer implements ObjectSerializable {
    @Serialized
    private List<String> strings = new ArrayList<>(Arrays.asList("test1", "test2", "test3", "test4"));
}
