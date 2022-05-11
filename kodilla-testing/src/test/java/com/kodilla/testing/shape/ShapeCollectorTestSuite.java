package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;


@DisplayName("Shape Collector Testing Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("tests starts here");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("tests ends here");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("preparing to execute tests no." + testCounter);
    }


    @Nested
    @DisplayName("Testing basic algorithms")
    public class AlgorithmsTesting {

        @Test
        void testTriangleFieldAlgorithm() {
            //Given
            Shape triangle = new Triangle(2, 3);

            //When
            double manualCalc = (2 * 3) / 2;

            //Then
            Assertions.assertEquals(triangle.getField(), manualCalc);
        }


        @Test
        void testSquareFieldAlgorithm() {
            //Given
            Shape square = new Square(2);

            //When
            double manualCalc = 2 * 2;

            //Then
            Assertions.assertEquals(square.getField(), manualCalc);
        }


        @Test
        void testCircleFieldAlgorithm() {
            //Given
            Shape circle = new Circle(2);

            //When
            double manualCalc = Math.PI * Math.pow(2, 2);

            //Then
            Assertions.assertEquals(circle.getField(), manualCalc);
        }
    }

    @Nested
    @DisplayName("Naming functionality testing")
    public class NamingTesting{

        @Test
        void testSquareReturnName() {
            //Given
            Shape square = new Square(2);

            //When
            String manualName = "Square";

            //Then
            Assertions.assertEquals(manualName,square.getShapeName());
        }

        @Test
        void testTriangleReturnName() {
            //Given
            Shape triangle = new Triangle(2,2);

            //When
            String manualName = "Triangle";

            //Then
            Assertions.assertEquals(manualName,triangle.getShapeName());
        }

        @Test
        void testCircleReturnName() {
            //Given
            Shape circle = new Circle(2);

            //When
            String manualName = "Circle";

            //Then
            Assertions.assertEquals(manualName,circle.getShapeName());
        }

    }

    @Nested
    @DisplayName("Shape Collector functionality testing")
    public class ShapeCollectorFeaturesTesting{

        @Test
        void testShapeCollectorGet() {
            //Given
            ShapeCollector shapeCollector=new ShapeCollector();
            Shape triangle = new Triangle(2, 3);

            //When
            shapeCollector.addFigure(triangle);
            Shape testShape=triangle;
            //Then
            Assertions.assertNull(shapeCollector.getFigure(4));
            Assertions.assertNull(shapeCollector.getFigure(-1));
            Assertions.assertEquals(testShape,shapeCollector.getFigure(0));

        }

        @Test
        void testShapeCollectorAdd () {
            //Given
            ShapeCollector shapeCollector=new ShapeCollector();
            Shape triangle = new Triangle(2, 3);

            //When
            shapeCollector.addFigure(triangle);

            //Then
            Assertions.assertEquals(triangle,shapeCollector.getFigure(0));
        }

        @Test
        void testShapeCollectorRemove() {
            //Given
            ShapeCollector shapeCollector=new ShapeCollector();
            Shape triangle = new Triangle(2, 3);
            shapeCollector.addFigure(triangle);

            //When
            boolean output=shapeCollector.removeFigure(triangle);

            //Then
            Assertions.assertTrue(output);
            Assertions.assertNull(shapeCollector.getFigure(0));
        }

        @Test
        void testShapeCollectorShowFigures() {
            //Given
            ShapeCollector shapeCollector=new ShapeCollector();
            Shape triangle = new Triangle(2, 3);
            Shape square = new Square(2);

            shapeCollector.addFigure(triangle);
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(square);

            //When
            String manualString="Triangle, Square, Square";
            String functionString=shapeCollector.showFigures();

            //Then
            Assertions.assertEquals(manualString,functionString);
        }
    }
}

