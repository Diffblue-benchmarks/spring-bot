package org.finos.springbot.workflow.java.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.finos.springbot.workflow.response.handlers.ResponseHandlers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

class CollectionResponseConverterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link CollectionResponseConverter#CollectionResponseConverter(ResponseHandlers)}
   *   <li>
   * {@link CollectionResponseConverter#setApplicationContext(ApplicationContext)}
   *   <li>{@link CollectionResponseConverter#getOrder()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() throws BeansException {
    // Arrange and Act
    CollectionResponseConverter actualCollectionResponseConverter = new CollectionResponseConverter(null);
    actualCollectionResponseConverter.setApplicationContext(new AnnotationConfigReactiveWebApplicationContext());

    // Assert that nothing has changed
    assertEquals(Integer.MAX_VALUE, actualCollectionResponseConverter.getOrder());
  }
}
