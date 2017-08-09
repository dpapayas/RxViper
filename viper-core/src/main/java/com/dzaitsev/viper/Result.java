/*
 * Copyright 2017 Dmytro Zaitsev
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

package com.dzaitsev.viper;

import javax.annotation.Nullable;

/**
 * ~ ~ ~ ~ Description ~ ~ ~ ~
 *
 * @author Dmytro Zaitsev
 * @since 2017-Aug-07, 16:58
 */
final class Result<T> {
  @Nullable final T         value;
  @Nullable final Throwable throwable;

  private Result(@Nullable T value, @Nullable Throwable throwable) {
    this.value = value;
    this.throwable = throwable;
  }

  static <T> Result<T> success(T value) {
    return new Result<>(value, null);
  }

  static <T> Result<T> error(Throwable throwable) {
    return new Result<>(null, throwable);
  }
}
