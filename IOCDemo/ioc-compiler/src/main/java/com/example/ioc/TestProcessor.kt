package com.example.ioc

import com.google.auto.service.AutoService
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeSpec
import sun.rmi.runtime.Log
import java.util.*
import javax.annotation.processing.AbstractProcessor
import javax.annotation.processing.Processor
import javax.annotation.processing.RoundEnvironment
import javax.lang.model.SourceVersion
import javax.lang.model.element.ExecutableElement
import javax.lang.model.element.TypeElement
import javax.lang.model.element.VariableElement

/**
 * 浙江集商优选电子商务有限公司
 * @author zenglw
 * @date   19-4-3 下午5:30
 */
@AutoService(Processor::class)
class TestProcessor : AbstractProcessor() {

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return LinkedHashSet<String>().apply {
            add(Bind::class.java.canonicalName)
        }
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: MutableSet<out TypeElement>?, roundEnv: RoundEnvironment?): Boolean {
        return roundEnv?.let {
            val elements = it.getElementsAnnotatedWith(ZlwAno::class.java)
            val argsList = arrayListOf<String>()
            elements.forEach { ele ->
                val annotation = ele.getAnnotation(ZlwAno::class.java) as ZlwAno

                when (ele) {
                    is TypeElement -> {
                        argsList.add("TypeElement: value = ${annotation.value}")


                    }

                    is VariableElement -> {
                    }


                    is ExecutableElement -> {

                    }

                    else -> {

                    }
                }
            }

            //打印日志信息
            val builder = TypeSpec.classBuilder("LoggerZlw").apply {
                addMethod(MethodSpec.methodBuilder("test").run {
                    for (value in argsList) {
                        addStatement("\$T arg = $value")
                    }
                    build()
                })
            }
            JavaFile.builder("test", builder.build())
                    .build()
                    .writeTo(processingEnv.filer)


            true

        } ?: true
    }
}