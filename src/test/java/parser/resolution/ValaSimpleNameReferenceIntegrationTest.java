package parser.resolution;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.testFramework.fixtures.BasePlatformTestCase;
import dev.vala.jetbrains.parser.psi.*;

public class ValaSimpleNameReferenceIntegrationTest extends BasePlatformTestCase {

    public void testShouldResolveLocalVariableInMethod() {

        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void main() {
                    int x = 1;
                    print (<caret>x);
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("x", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldResolveLocalVariableInClass() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                class Test {
                    string name = "John";
                    print (<caret>name);
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("name", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldResolveFirstParameterInMethod() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void sum(int a, int b) {
                    int result = <caret>a + b;
                
                    return result;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaParameter.class);
        assertEquals("a", ((ValaParameter) resolved).getName());
    }

    public void testShouldResolveSecondParameterInMethod() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void sum(int a, int b) {
                    int result = a + <caret>b;
                
                    return result;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaParameter.class);
        assertEquals("b", ((ValaParameter) resolved).getName());
    }

    public void testShouldResolveLocalVariableInForeach() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main() {
                
                    int[] nums = {
                       1, 2, 3, 4, 5
                    };
                
                    foreach (int num in <caret>nums) {
                        stdout.printf ("%d", num);
                    }
                
                    return 1;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("nums", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldResolveForeach() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main() {
                
                    int[] nums = {
                       1, 2, 3, 4, 5
                    };
                
                    foreach (int num in nums) {
                        stdout.printf ("%d", <caret>num);
                    }
                
                    return 1;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaForeachStatement.class);
        assertEquals("num", ((ValaForeachStatement) resolved).getName());
    }

    public void testShouldResolveForInitializedVariable() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void main () {
                    for (int i = 0; i < 10; i++) {
                        stdout.printf ("%d", <caret>i);
                    }
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("i", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldResolveLocalVariableInCatch() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main() {
                
                    try {
                        print ("test");
                    } catch (Error e) {
                        print (<caret>e.message);
                    }
                
                    return 1;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaCatchClause.class);
        assertEquals("e", ((ValaCatchClause) resolved).getName());
    }

    public void testShouldResolveLocalVariableInWith() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main() {
                
                    with (string name = "Test") {
                        print (<caret>name + "\\n");
                    }
                
                    return 1;
                }
                
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("name", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldResolveConstantLocalVariableInMethod() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void main ()
                {
                    const int VAL = 5;
                
                    stdout.printf ("%d\n", <caret>VAL);
                
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaConstantDeclaration.class);
        assertEquals("VAL", ((ValaConstantDeclaration) resolved).getName());
    }

    public void testShouldResolveConstantLocalVariableTailInMethod() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                void main ()
                {
                    const int VAL = 5, VAL_TWO = 10, VAL_THREE = 20;
                
                    stdout.printf ("%d\n", <caret>VAL_THREE);
                
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaConstantDeclaration.class);
        assertEquals("VAL_THREE", ((ValaConstantDeclaration) resolved).getName());
    }

    public void testShouldResolveLambdaExpressionParamInLambdaExpression() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                delegate void test (string a);
                
                void main ()
                {
                    test t = (a) => {
                        print(<caret>a);
                    };
                
                    t ("t");
                
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLambdaExpressionParam.class);
        assertEquals("a", ((ValaLambdaExpressionParam) resolved).getName());
    }

    public void testShouldResolveTailOfLocalVariableDeclarationInList() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main ()
                {
                    int a = 1, b = 2, c = 3;
                
                    stdout.printf ("%d\n", <caret>c);
                
                    return 1;
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaLocalVariable.class);
        assertEquals("c", ((ValaLocalVariable) resolved).getName());
    }

    public void testShouldNotResolveUndeclaredItem() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                int main ()
                {
                    stdout.printf ("%s", <caret>c);
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNull(resolved);
    }

    public void testShouldNotResolveMemberItem() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                public struct Color {
                    int red;
                    int green;
                    int blue;
                }
                
                void main ()
                {
                    Color c = Color () { red = 1, green = 2, blue = 3 };
                
                    print ("red: %d, green: %d, blue: %d\n", c.<caret>red, c.green, c.blue);
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNull(reference);
    }

    public void testShouldResolveMethodParameterOverOuterVariable() {
        myFixture.configureByText("test.vala",
            // language=Vala
            """
                class Foo {
                    int x = 1;
                    void bar(int x) {
                        stdout.printf ("%d", <caret>x);
                    }
                }
                """);

        PsiElement elementAtCaret = myFixture.getFile().findElementAt(myFixture.getCaretOffset());
        ValaSimpleName simpleName = PsiTreeUtil.getParentOfType(elementAtCaret, ValaSimpleName.class);

        assertNotNull(simpleName);

        PsiReference reference = simpleName.getReference();

        assertNotNull(reference);

        PsiElement resolved = reference.resolve();

        assertNotNull(resolved);
        assertInstanceOf(resolved, ValaParameter.class);
        assertEquals("x", ((ValaParameter) resolved).getName());
    }
}
