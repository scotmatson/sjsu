################################################################################
# Automatically-generated file. Do not edit!
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
C_SRCS += \
../hw07/getch.c \
../hw07/getop.c \
../hw07/hw7.c \
../hw07/main.c \
../hw07/stack.c 

OBJS += \
./hw07/getch.o \
./hw07/getop.o \
./hw07/hw7.o \
./hw07/main.o \
./hw07/stack.o 

C_DEPS += \
./hw07/getch.d \
./hw07/getop.d \
./hw07/hw7.d \
./hw07/main.d \
./hw07/stack.d 


# Each subdirectory must supply rules for building sources it contributes
hw07/%.o: ../hw07/%.c
	@echo 'Building file: $<'
	@echo 'Invoking: GCC C Compiler'
	gcc -O0 -g3 -Wall -c -fmessage-length=0 -MMD -MP -MF"$(@:%.o=%.d)" -MT"$(@:%.o=%.d)" -o "$@" "$<"
	@echo 'Finished building: $<'
	@echo ' '


