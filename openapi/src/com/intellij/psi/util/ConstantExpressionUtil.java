/*
 * Copyright 2000-2005 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intellij.psi.util;

import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiType;

@SuppressWarnings({"HardCodedStringLiteral"})
public class ConstantExpressionUtil {
  public static Object computeCastTo(PsiExpression expression, PsiType castTo) {
    if (expression == null) return null;
    Object value = expression.getManager().getConstantEvaluationHelper().computeConstantExpression(expression, false);
    if(value == null) return null;
    return computeCastTo(value, castTo);
  }

  public static Object computeCastTo(Object operand, PsiType castType) {
    return TypeConversionUtil.computeCastTo(operand, castType);
  }

}
