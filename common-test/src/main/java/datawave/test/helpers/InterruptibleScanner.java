package datawave.test.helpers;

import org.apache.accumulo.core.client.Scanner;
import org.apache.accumulo.core.data.Key;
import org.apache.accumulo.core.data.Value;

import java.util.Iterator;
import java.util.Map.Entry;

/**
 * <p>
 * This mock scanner can be interrupted at any time, refreshing/cloning the iterator and resetting the range. This is to help to test tear down scenarios, the
 * deep copy usage and sequential key output.
 * </p>
 * 
 * <p>
 * Create this scanner with an existing <code>MockScanner</code> from the mock package. At any point in testing a new iterator can be generated using the the
 * interrupt method. The old iterator will still be usable but will not actually test the interruption scenario.
 * </p>
 * 
 * <p>
 * Example usage
 * </p>
 * 
 * <pre>
 * Scanner s = conn.createScanner(TABLE_NAME, authorizations);
 * InterruptibleScanner scanner = new InterruptibleScanner(s);
 * // TODO: Configure scanner, set range
 * Iterator&lt;Entry&lt;Key,Value&gt;&gt; iter = scanner.iterator();
 * // TODO: iterator over key values, test some values
 * iter = scanner.interrupt(); // Simulate a tear down
 * // TODO: test this value is the expected next value, has not returned a duplicate
 * </pre>
 */
public interface InterruptibleScanner extends Scanner {
    
    Iterator<Entry<Key,Value>> interrupt();
}
