/*
 * Copyright 2016 Dmytro Zaitsev
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dzaitsev.rxviper;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Nonnull;
import rx.functions.Func1;

import static com.dzaitsev.rxviper.RxViper.requireNotNull;

/**
 * Converts entities to basic model objects used by the {@link Interactor}.
 * <p>
 * Given an input object maps to an appropriate output object. A mapper may variously provide a mapping between types, object instances
 * or keys and values or any other form of transformation upon the input.
 * <p>
 * All mapper implementations are expected to:
 * <ul>
 * <li>Provide stable results such that for any t the result of two map operations are always equivalent.</li>
 * <li>Equivalent input objects should map to equivalent output objects.</li>
 * <li>The mapper should not modify the input object in any way that would change the mapping.</li>
 * <li>
 * When used for aggregate operations upon many elements mappers should not assume that the {@link #map} operation will be called upon
 * elements in any specific order.</li>
 * </ul>
 *
 * @param <From> the type of input objects provided to the map operation.
 * @param <To> the type of output objects from map operation. May be the same type as {@code <From>}.
 *
 * @author Dmytro Zaitsev
 * @since 0.1.0
 */
public abstract class Mapper<From, To> implements Func1<From, To> {
  /* @since 0.10.0 */
  @Override
  public final To call(@Nonnull From from) {
    requireNotNull(from);
    return map(from);
  }

  /**
   * Map the provided collection of input objects to an appropriate collection of output objects.
   *
   * @param entities the {@code Collection} of input objects
   *
   * @return collection of output objects
   *
   * @since 0.1.0
   */
  public Collection<To> map(@Nonnull Collection<From> entities) {
    requireNotNull(entities);
    final Collection<To> result = new ArrayList<>(entities.size());
    //noinspection Convert2streamapi
    for (From from : entities) {
      result.add(map(from));
    }
    return result;
  }

  /**
   * Map the provided input object to an appropriate output object.
   *
   * @param entity the input object
   *
   * @return output object
   *
   * @since 0.1.0
   */
  public abstract To map(From entity);
}
