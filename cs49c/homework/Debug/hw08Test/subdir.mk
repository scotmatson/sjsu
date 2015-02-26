################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../hw08Test/getch.c \
../hw08Test/getop.c \
../hw08Test/hw8.c \
../hw08Test/main.c \
../hw08Test/stack.c 

OBJS += \
./hw08Test/getch.o \
./hw08Test/getop.o \
./hw08Test/hw8.o \
./hw08Test/main.o \
./hw08Test/stack.o 

C_DEPS += \
./hw08Test/getch.d \
./hw08Test/getop.d \
./hw08Test/hw8.d \
./hw08Test/main.d \
./hw08Test/stack.d 


# Each subdirectory must supply rules for building sources it contributes
hw08Test/%.o: ../hw08Test/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


